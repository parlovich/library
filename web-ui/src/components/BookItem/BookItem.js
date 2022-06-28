import React from "react";

import { Card } from "../Card/Card";

export default (props) => {
    const {title, author} = props
    return (
        <Card className="book-item">
            <div>{props.title}</div>
        </Card>
    )
}