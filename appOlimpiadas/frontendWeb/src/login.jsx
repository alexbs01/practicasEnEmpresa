import './styles/login.css'
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import React, { useState } from 'react';
import { handleLogin, handleRegister } from './controller/login/loginController';

function Login({ toggleIsLogged }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const sendToHandleLogin = (username, password) => {
        handleLogin(toggleIsLogged, username, password);
    };

    const sendToHandleRegister = (username, password) => {
        handleRegister(username, password);
    };

    return (
        <div className='mainDiv'>
            <div className='div-form'>
                <Typography variant="h1" component="h1" gutterBottom>
                    No sé que nombre ponerle
                </Typography>
                <Paper className='paper' elevation={3}>
                    <TextField
                        className='textField'
                        required
                        id="outlined-required"
                        label="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </Paper>
                <Paper className='paper' elevation={3}>
                    <TextField
                        className='textField'
                        id="outlined-required"
                        label="Password"
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </Paper>
            </div>
            <div className='div-buttons'>
                <Paper className='paper-buttons' elevation={3}>
                    <Button 
                        className='button' 
                        variant="contained"
                        size='large'
                        onClick={() => sendToHandleLogin(username, password)}>
                            Login
                    </Button>
                </Paper>
                <Paper className='paper-buttons' elevation={3}>
                    <Button 
                        className='button' 
                        variant="outlined"
                        size='large'
                        onClick={() => sendToHandleRegister(username, password)}> {/* Aquí envuelvo la función en otra función */}
                            Register
                    </Button>
                </Paper>
            </div>
        </div>
    );
}

export default Login;
