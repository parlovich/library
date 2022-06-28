import React from "react";

import "./NewBookForm.css";

export default (props) => {
    const [title, setTitle] = React.useState('');
    const [author, setAuthor] = React.useState('');
    const [image, setImage] = React.useState('');

    const changeTitleHandler = (event) => {
        setTitle(event.target.value);
    }

    const submitHandler = (event) => {
        event.preventDefault();
    }

    return (
        <form onSubmit={submitHandler}>
            <div className="new-book__controls">
                <div className="new-book__control">
                    <label>Title</label>
                    <input type="text" name="title" value={title} onChange={changeTitleHandler}/>
                </div>
            </div>
            <div className="new-book__actions">
                <button type="submit">Add</button>
            </div>
        </form>
    );

}