import React from "react";

import BooksCollection from "./components/BooksCollection/BooksCollection";
import NewBook from "./components/NewBook/NewBook";

const INITIAL_BOOKS = [
  {
    title: "The C++ Programming Language (4th Edition)",
    author: "Bjarne Stroustrup",
    image: "https://www.stroustrup.com/4thEnglish.JPG",
    available: 5,
  },
  {
    title: "Patterns of Enterprise Application Architecture",
    author: "Martin Fowler",
    image: "https://www.martinfowler.com/books/eaa.jpg",
    available: 3,
  },
];

const App = () => {
  const [books, setBooks]  = React.useState(INITIAL_BOOKS);
  
  const onNewBook = (book) => {

  };

  return (
    <div>
      <h1>Welcome to Library</h1>
      <NewBook onNewBook={onNewBook}/>
      <BooksCollection books={books}/>
    </div>
  );
};

export default App;
