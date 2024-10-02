function Button({onClick, text}) {
    return (
        <div className="div-buttons">
            <button className="buttons-left" onClick={onClick}>
                {text}
            </button>
        </div>
        
    );
}

export default Button;