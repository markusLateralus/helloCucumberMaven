Feature: Comprar memoria RAM en amazon

Scenario Outline:
comprar memoria RAM en amazon estando logado

Given yo como usuario estoy logado correctamente
 
When realizo una búsqueda de "<objeto>" en el buscador
And elijo el primer objeto de la lista

Then compruebo que el precio sea inferior de 100 euros.

Examples:
| objeto  |
| coches  |
| motos   |