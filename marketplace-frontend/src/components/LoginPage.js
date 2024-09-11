import React from 'react';
import { Container, Typography, TextField, Button, Box } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {
  const navigate = useNavigate(); // Хук для навигации

  const handleRegisterClick = () => {
    navigate('/register'); // Переход на страницу регистрации
  };

  const handleLogin = (event) => {
    event.preventDefault();
    // Логика для обработки входа пользователя
  };

  return (
    <Container>
      <Box sx={{ maxWidth: 600, margin: 'auto', marginTop: 4, padding: 3, borderRadius: 2, boxShadow: 3 }}>
        <Typography variant="h4" component="h1" gutterBottom>
          Login
        </Typography>
        <form onSubmit={handleLogin}>
          <TextField
            label="Email"
            variant="outlined"
            fullWidth
            margin="normal"
            required
          />
          <TextField
            label="Password"
            type="password"
            variant="outlined"
            fullWidth
            margin="normal"
            required
          />
          <Button type="submit" variant="contained" color="primary" fullWidth sx={{ marginTop: 2 }}>
            Login
          </Button>
        </form>
        <Button
          variant="text"
          color="secondary"
          fullWidth
          sx={{ marginTop: 2 }}
          onClick={handleRegisterClick}
        >
          Don't have an account? Register
        </Button>
      </Box>
    </Container>
  );
};

export default LoginPage;
