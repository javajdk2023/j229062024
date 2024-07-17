# Atividade 3

Implemente na classe UsuarioDAO cada 1 dos comandos de select abaixo:

1. **Selecionar todas as colunas de todas as pessoas com idade entre 25 e 35 anos:**
   ```sql
   SELECT * FROM tabela WHERE idade BETWEEN 25 AND 35;
   ```

2. **Selecionar apenas o nome e CPF das pessoas cujo nome começa com 'A':**
   ```sql
   SELECT * FROM tabela WHERE nome LIKE 'A%';
   ```

3. **Selecionar o nome e idade das pessoas ordenadas pela idade de forma decrescente:**
   ```sql
   SELECT * FROM tabela ORDER BY idade DESC;
   ```

4. **Selecionar o código e nome das pessoas onde o CPF é nulo (caso CPF permita nulo):**
   ```sql
   SELECT * FROM tabela WHERE cpf IS NULL;
   ```

5. **Selecionar o nome das pessoas que não têm idade registrada (idade é nula):**
   ```sql
   SELECT * FROM tabela WHERE idade IS NULL;
   ```

6. **Selecionar o nome e idade das 3 pessoas mais velhas (por idade):**
   ```sql
   SELECT * FROM tabela ORDER BY idade DESC LIMIT 3;
   ```

7. **Selecionar o código e nome das pessoas que têm CPF válido (não nulo e não vazio):**
   ```sql
   SELECT * FROM tabela WHERE cpf IS NOT NULL AND cpf != '';
   ```

8. **Selecionar o nome e idade das pessoas que têm idade maior que a média das idades registradas:**
   ```sql
   SELECT * FROM tabela WHERE idade > (SELECT AVG(idade) FROM tabela);
   ```

9. **Selecionar o código, nome e idade das pessoas que têm idade entre 20 e 30 anos e cujo nome não começa com 'J':**
   ```sql
   SELECT * FROM tabela WHERE idade BETWEEN 20 AND 30 AND nome NOT LIKE 'J%';
   ```

10. **Selecionar o nome das pessoas e uma nova coluna chamada 'categoria' baseada na idade (menor que 18 anos: 'Menor de idade', entre 18 e 65 anos: 'Adulto', e acima de 65 anos: 'Idoso'):**
    ```sql
    SELECT nome,
           CASE
               WHEN idade < 18 THEN 'Menor de idade'
               WHEN idade >= 18 AND idade <= 65 THEN 'Adulto'
               ELSE 'Idoso'
           END AS categoria
    FROM tabela;
    ```
