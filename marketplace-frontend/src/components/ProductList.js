import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Container, Grid, Card, CardContent, Typography, CardMedia, CircularProgress, Pagination } from '@mui/material';
import { makeStyles } from '@mui/styles';

const useStyles = makeStyles({
  card: {
    display: 'flex',
    flexDirection: 'column',
    height: '100%',
    cursor: 'pointer', // Добавьте курсор указателя для визуального эффекта
  },
  media: {
    height: 140,
    objectFit: 'cover',
  },
  content: {
    flexGrow: 1,
  },
  pagination: {
    marginTop: 20,
    display: 'flex',
    justifyContent: 'center',
  },
});

const ProductList = () => {
  const classes = useStyles();
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [page, setPage] = useState(1); // Текущая страница
  const [totalPages, setTotalPages] = useState(1); // Общее количество страниц

  const navigate = useNavigate(); // Хук для навигации

  useEffect(() => {
    fetch(`http://localhost:8080/products?page=${page}&size=9`)
      .then((response) => response.json())
      .then((data) => {
        setProducts(data.products); // Предполагается, что API возвращает объект с полем products
        setTotalPages(data.totalPages); // Общее количество страниц от API
        setLoading(false);
      })
      .catch((err) => {
        setError(err);
        setLoading(false);
      });
  }, [page]);

  if (loading) return <CircularProgress />;

  if (error) return <Typography color="error">Ошибка загрузки товаров: {error.message}</Typography>;

  const handleCardClick = (id) => {
    navigate(`/product/${id}`); // Переход на страницу продукта по его ID
  };

  return (
    <Container>
      <Grid container spacing={4}>
        {products.map((product) => (
          <Grid item xs={12} sm={6} md={4} key={product.id}>
            <Card className={classes.card} onClick={() => handleCardClick(product.id)}>
              <CardMedia
                component="img"
                alt={product.name}
                className={classes.media}
                image={product.imageUrl} // Замените на URL изображения товара
              />
              <CardContent className={classes.content}>
                <Typography variant="h6" component="div">
                  {product.name}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  {product.description}
                </Typography>
                <Typography variant="h6" component="div">
                  ${product.price}
                </Typography>
              </CardContent>
            </Card>
          </Grid>
        ))}
      </Grid>
      <div className={classes.pagination}>
        <Pagination
          count={totalPages}
          page={page}
          onChange={(event, value) => setPage(value)}
          color="primary"
        />
      </div>
    </Container>
  );
};

export default ProductList;
