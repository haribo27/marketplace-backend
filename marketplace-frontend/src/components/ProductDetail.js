import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Typography, CircularProgress, Box, Button, Grid, IconButton } from '@mui/material';
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import StarIcon from '@mui/icons-material/Star';
import StarBorderIcon from '@mui/icons-material/StarBorder';

const ProductDetail = () => {
  const { id } = useParams(); // Получаем ID продукта из URL
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [isFavorite, setIsFavorite] = useState(false); // Состояние для избранного
  const [hoverRating, setHoverRating] = useState(null); // Рейтинг при наведении

  useEffect(() => {
    fetch(`http://localhost:8080/products/${id}`) // Замените на ваш API
      .then((response) => response.json())
      .then((data) => {
        setProduct(data); // Предполагается, что API возвращает объект продукта
        setLoading(false);
      })
      .catch((err) => {
        setError(err);
        setLoading(false);
      });
  }, [id]);

  if (loading) return <CircularProgress />;

  if (error) return <Typography color="error">Ошибка загрузки продукта: {error.message}</Typography>;

  const handleFavoriteToggle = () => {
    setIsFavorite(prev => !prev); // Переключение состояния избранного
  };

  const renderStars = (rating) => {
    const stars = [];
    for (let i = 0; i < 5; i++) {
      stars.push(
        <IconButton
          key={i}
          onMouseEnter={() => setHoverRating(i + 1)} // При наведении устанавливаем рейтинг
          onMouseLeave={() => setHoverRating(null)} // При уходе курсора сбрасываем рейтинг
          onClick={() => {}}
          sx={{
            padding: '0',
          }}
        >
          {i < rating ? (
            <StarIcon color="primary" />
          ) : (
            <StarBorderIcon color="action" />
          )}
        </IconButton>
      );
    }
    return stars;
  };

  return (
    <Container>
      {product && (
        <Grid container spacing={4} sx={{ marginTop: '20px' }}>
          {/* Левый блок с изображением */}
          <Grid item xs={12} md={6}>
            <Box
              sx={{
                position: 'relative', // Чтобы разместить иконки поверх изображения
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                height: '100%',
                borderRadius: '8px',
                boxShadow: '0px 4px 12px rgba(0, 0, 0, 0.1)',
                padding: '20px',
                backgroundColor: '#f9f9f9',
              }}
            >
              <img
                src={product.imageUrl}
                alt={product.name}
                style={{
                  maxWidth: '100%',
                  maxHeight: '450px',
                  objectFit: 'cover',
                }}
              />
              {/* Иконка сердца для избранного */}
              <IconButton
                onClick={handleFavoriteToggle}
                sx={{
                  position: 'absolute',
                  top: '20px',
                  right: '20px',
                  color: isFavorite ? 'red' : 'white',
                  backgroundColor: 'rgba(0, 0, 0, 0.5)',
                  borderRadius: '50%',
                  padding: '10px',
                }}
              >
                {isFavorite ? <FavoriteIcon /> : <FavoriteBorderIcon />}
              </IconButton>
              {/* Оценка по 5 звездам */}
              <Box
                sx={{
                  position: 'absolute',
                  bottom: '20px',
                  left: '20px',
                  display: 'flex',
                  gap: '5px',
                }}
              >
                {renderStars(hoverRating !== null ? hoverRating : product.rating || 0)} {/* Отображаем рейтинг при наведении или текущий рейтинг */}
              </Box>
            </Box>
          </Grid>

          {/* Правый блок с информацией */}
          <Grid item xs={12} md={6}>
            <Box sx={{ padding: '20px' }}>
              <Typography variant="h4" component="h1" gutterBottom>
                {product.name}
              </Typography>
              <Typography variant="h6" color="textSecondary" gutterBottom>
                ${product.price}
              </Typography>
              <Typography variant="body1" component="p" gutterBottom>
                {product.description}
              </Typography>

              {/* Кнопки "Добавить в корзину" и "Купить сейчас" */}
              <Box sx={{ marginTop: '20px' }}>
                <Button
                  variant="contained"
                  color="primary"
                  size="large"
                  sx={{
                    width: '100%',
                    padding: '15px',
                    borderRadius: '8px',
                    marginBottom: '10px',
                  }}
                >
                  Добавить в корзину
                </Button>
                <Button
                  variant="outlined"
                  color="primary"
                  size="large"
                  sx={{
                    width: '100%',
                    padding: '15px',
                    borderRadius: '8px',
                  }}
                >
                  Купить сейчас
                </Button>
              </Box>
            </Box>
          </Grid>
        </Grid>
      )}
    </Container>
  );
};

export default ProductDetail;
