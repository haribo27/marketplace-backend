import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ProductList from './components/ProductList'; // Список продуктов
import ProductDetail from './components/ProductDetail';
import Appbar from './components/Appbar'; // Страница продукта
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';

const App = () => {
  return (
    
    <Router>
      <div className="App">
       <Appbar/>
    </div>
      <Routes>
        {/* Маршрут для списка продуктов */}
        <Route path="/" element={<ProductList />} />
        {/* Маршрут для детальной страницы продукта */}
        <Route path="/product/:id" element={<ProductDetail />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
      </Routes>
    </Router>
  );
};

export default App;
