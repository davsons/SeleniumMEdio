Feature: Spotify Test

  Scenario Outline:
    Given Estoy en el Sitio Spotify
    When  Ingreso a Premium
    And   <Plan>
    Then  Estoy en Plan Individual
    Then  Estoy en Plan Premium Familiar

    Examples:
      | Plan |
      | Individual|
      | Premium|


  Scenario:
    Given Estoy en el Sitio Spotify
    When  Entro a Terminos y Condiciones
    And   Disfrutando Spotify
    And   Pagos, cancelaciones y periodo de reflexion
    Then  Uso de nuestro servicio


  Scenario Outline:
    Given Estoy en el Sitio Spotify
    When  Me registro
    Then  Email <email>

    Examples:
      | email |
      | Vacio|
      | Invalido|
      | Existente|














