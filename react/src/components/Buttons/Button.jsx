function Button({onClick, text}) {
    return (
        <button className="button-left" onClick={onClick}>
            {text}
        </button>
    );
}

export default Button;