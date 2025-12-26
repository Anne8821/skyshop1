package org.skypro.skyshop.model.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.Product;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    private ProductBasket productBasket;

    @Mock
    private StorageService storageService;

    @InjectMocks
    private BasketService basketService;

    @Test
    void shouldThrowExceptionWhenProductNotFound() {
        UUID invalidId = UUID.randomUUID();

        when(storageService.getProductById(invalidId))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> basketService.addProduct(invalidId)
        );
    }

    @Test
    void shouldReturnEmptyBasketWhenNoProducts() {
        when(productBasket.getProducts())
                .thenReturn(Collections.emptyMap());

        UserBasket userBasket = basketService.getUserBasket();

        assertThat(userBasket.getItems()).isEmpty();
        assertThat(userBasket.getTotal()).isZero();
    }

    @Test
    void shouldReturnBasketWithProducts() {
        UUID productId = UUID.randomUUID();
        Product product = new SimpleProduct("TestProduct", 200);

        when(productBasket.getProducts())
                .thenReturn(Map.of(productId, 3));
        when(storageService.getProductById(productId))
                .thenReturn(Optional.of(product));

        UserBasket userBasket = basketService.getUserBasket();

        assertThat(userBasket.getItems()).hasSize(1);
        assertThat(userBasket.getTotal()).isEqualTo(600);
    }

    @Test
    void shouldAddProductToBasketWhenProductExists() {
        UUID validId = UUID.randomUUID();
        Product product = new SimpleProduct("TestProduct", 100);

        when(storageService.getProductById(validId))
                .thenReturn(Optional.of(product));

        basketService.addProduct(validId);

        verify(productBasket, times(1)).addProduct(validId);
    }
}



