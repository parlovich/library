# This data source is included for ease of sample architecture deployment
# and can be swapped out as necessary.
data "aws_availability_zones" "available" {
}

resource "aws_vpc" "library" {
  cidr_block = "10.0.0.0/16"

  enable_dns_support = true
  enable_dns_hostnames = true

  tags = {
    "Name" = "library"
  }
}

# public subnet
resource "aws_subnet" "library-public" {
  count = 2

  vpc_id = aws_vpc.library.id
  availability_zone = data.aws_availability_zones.available.names[count.index]
  cidr_block = "10.0.${count.index}.0/24"
  map_public_ip_on_launch = true

  tags = {
    "Name" = "library-public"
  }
}


# Two private subnets
resource "aws_subnet" "library-private" {
  count = 2

  vpc_id = aws_vpc.library.id
  availability_zone = data.aws_availability_zones.available.names[count.index]
  cidr_block = "10.0.${count.index + 2}.0/24"

  tags = {
    "Name" = "library-private"
  }
}

# Internet gateway
# Allows all the IP4 traffic from the public subnets to go to the internet gateway
resource "aws_internet_gateway" "library" {
  vpc_id = aws_vpc.library.id

  tags = {
    Name = "library"
  }
}

resource "aws_route_table" "library" {
  vpc_id = aws_vpc.library.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.library.id
  }
}

resource "aws_route_table_association" "demo-mesh" {
  count = 2

  subnet_id = aws_subnet.library-public[count.index].id
  route_table_id = aws_route_table.library.id
}


# NAT Gateway to let access to services from private subnets

resource "aws_eip" "nat" {
  count = 2
}

resource "aws_nat_gateway" "library" {
  count = 2

  allocation_id = aws_eip.nat[count.index].id
  subnet_id = aws_subnet.library-public[count.index].id

  tags = {
    Name = "library NAT gateway"
  }

  depends_on = [
    aws_internet_gateway.library,
    aws_subnet.library-private
  ]
}

resource "aws_route_table" "private-subnet" {
  count = 2

  vpc_id = aws_vpc.library.id

  route {
    cidr_block = "0.0.0.0/0"
    nat_gateway_id = aws_nat_gateway.library[count.index].id
  }

  tags = {
    Name = "NAT route"
  }
}

resource "aws_route_table_association" "private-subnet" {
  count = 2
  subnet_id = aws_subnet.library-private[count.index].id
  route_table_id = aws_route_table.private-subnet[count.index].id
}
