
Feature: Validate Login to fetch the accesstoken and order a book



  Scenario: verify login API
    Given login API
    When Login Execute "/api-clients/" and provide accesstoken
    Then successfully execute with status code 201
    And verify accesstoken

 
  Scenario: order a book
    Given Login successfull with accesstoken
    When order a book "/orders" and fetch orderid
    Then verify status code 201
