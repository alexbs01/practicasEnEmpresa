import './login.css'

import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { Paper } from '@mui/material';

function Login() {
    return (
        <div className='mainDiv'>
            <div className='div-form'>
                <Typography variant="h2" component="h1" gutterBottom>
                    No sé que nombre ponerle
                </Typography>
                <Paper className='paper' elevation={3}>
                    <TextField
                        required
                        id="outlined-required"
                        label="Username"
                    />
                </Paper>
                <Paper className='paper' elevation={3}>
                    <TextField
                        id="outlined-required"
                        label="Password"
                    />
                </Paper>
            </div>
            <div className='div-buttons'>
                <Paper className='paper-buttons' elevation={3}>
                    <Button className='button' variant="contained">Login</Button>
                </Paper>
                <Paper className='paper-buttons' elevation={3}>
                    <Button className='button' variant="outlined">Register</Button>
                </Paper>
            </div>
        </div>
    );
}

export default Login;