@cartStore
Feature: Shopping Cart Funcionality

  @test
  Scenario Outline: Validar la funcionalidad del carrito de compras

    Given estoy en la aplicación de SauceLabs
    Given valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                  | UNIDADES            |
      | Sauce Labs Backpack       | 1                   |
      | Sauce Labs Bolt - T-Shirt | 1                   |
      | Sauce Labs Bike Light     | 2                   |