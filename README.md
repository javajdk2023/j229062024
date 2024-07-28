## Criação do Projeto

### Digite ctrl + n

![image](https://github.com/user-attachments/assets/fe4262b2-08c0-4b81-af3f-d96b7bcd6bdb)

### Digite e escolha o projeto Maven

![image](https://github.com/user-attachments/assets/faa657d0-9d22-4505-9b72-4b7290719491)

### Criar um projeto Simples

![image](https://github.com/user-attachments/assets/ead8b8f0-6549-46c4-ac23-a476b6a253ac)

Crie um projeto utilizando o Maven com as seguintes configurações:

* GropID: **br.com.fuctura**
* ArtifactID: **sistemaGerenciadorDeVeiculosProjetoJPAAluno**

![image](https://github.com/user-attachments/assets/1fc626a3-c298-4703-893f-a5789daf53de)

### Configure a versão do Java para 17

![image](https://github.com/javajdk2023/j05032024/assets/130251409/28973124-5ae1-499e-bcc6-7421c73101a8)

Adicione a *tag* **properties** no seu arquivo **pom.xml**

```
  <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>
```

### Atualizar o Projeto

Clique no nome do projeto 

![image](https://github.com/javajdk2023/j05032024/assets/130251409/e368f93b-816d-4eae-89ce-ee6b40b6f0dc)


Pressione **ALT + F5**. Uma nova tela aparecerá. Clique em  **OK**

Esta opção força o Eclipse a fazer a leitura do arquivo **pom.xml** e atualizar o seu projeto.

![image](https://github.com/javajdk2023/j05032024/assets/130251409/c41eaf54-fd9b-47f8-a5af-dab960a03675)

Confirmar se a versão do Java foi atualizada para 17

![image](https://github.com/javajdk2023/j05032024/assets/130251409/e23443a1-ee60-4011-a489-2d5cf1931e64)


### Dependências

Adicione as seguintes dependências no seu arquivo **pom.xml**:

* https://mvnrepository.com/artifact/org.postgresql/postgresql/42.7.3
```
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>
```

* https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core/6.5.2.Final
```
<!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.5.2.Final</version>
</dependency>
```

### Atualizar o Projeto (repita o passo de atualização acima)

### Visualizar as Dependências adicionadas no Projeto


![image](https://github.com/user-attachments/assets/489fc03d-c3e8-4a53-ad33-70d336913983)


### Versão final do POM.xml

```
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>br.com.fuctura</groupId>
	<artifactId>SistemaGerenciadorDeVeiculoJPAAluno</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<properties>
		<maven.compiler.source>17</maven.compiler.source>
		<maven.compiler.target>17</maven.compiler.target>
	</properties>

	<dependencies>

		<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.7.3</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
		<dependency>
			<groupId>org.hibernate.orm</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>6.5.2.Final</version>
		</dependency>

	</dependencies>

</project>
```


# JPA (Java Persistence API)

O JPA (Java Persistence API) é uma especificação que fornece uma maneira padronizada de lidar com persistência de dados em aplicações Java. Ele utiliza anotações para mapear classes Java para tabelas em um banco de dados relacional. Aqui estão algumas das principais anotações do JPA:

1. **@Entity**: Marca uma classe como uma entidade JPA que deve ser mapeada para uma tabela no banco de dados.

2. **@Table**: Especifica o nome da tabela no banco de dados com a qual a entidade será mapeada. Se não for especificado, o nome da tabela será o mesmo da classe.

3. **@Id**: Marca um campo como o identificador único da entidade. É equivalente à chave primária na tabela do banco de dados.

4. **@GeneratedValue**: Define a estratégia de geração do valor da chave primária. Pode usar estratégias como `AUTO`, `IDENTITY`, `SEQUENCE` ou `TABLE`.

5. **@Column**: Mapeia um campo de uma entidade para uma coluna na tabela do banco de dados. Permite definir propriedades como nome da coluna, tipo, comprimento e se ela pode ser nula.


### EntityManagerFactory

**EntityManagerFactory** é um componente central no contexto de JPA que é responsável pela criação e gerenciamento de instâncias de **EntityManager**. Suas principais responsabilidades e características são:

1. **Criação de EntityManagers**: O **EntityManagerFactory** cria instâncias de **EntityManager**, que são usadas para interagir com o banco de dados.

2. **Gerenciamento de Recursos**: Ele gerencia os recursos necessários para a persistência, como a conexão com o banco de dados e o contexto de persistência.

3. **Escopo de Vida**: O **EntityManagerFactory** é um objeto caro em termos de recursos, portanto, deve ser criado uma vez e reutilizado ao longo da aplicação. Normalmente, ele é criado na inicialização da aplicação e destruído na sua finalização.

4. **Configuração**: Ele é configurado usando um arquivo de configuração chamado `persistence.xml`, que define a unidade de persistência, propriedades de conexão, e outras configurações necessárias.

5. **Uso**: O método `createEntityManagerFactory` da classe `Persistence` é usado para criar uma instância de **EntityManagerFactory**.

   ```java
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
   ```

6. **Destruição**: Deve ser fechado quando não for mais necessário, para liberar os recursos associados.

   ```java
   emf.close();
   ```

### EntityManager

**EntityManager** é a interface principal usada para interagir com o contexto de persistência. Suas principais responsabilidades e características são:

1. **Operações CRUD**: O **EntityManager** fornece métodos para realizar operações básicas de CRUD (Create, Read, Update, Delete) em entidades.

```
EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUCTURA-PU");

EntityManager manager =  factory.createEntityManager();

Usuario usuario = new Usuario();
usuario.setNome("Fuctura");
usuario.setIdade(90);
usuario.setCpf("123456789");

manager.getTransaction().begin();
manager.persist(usuario); //insert
manager.getTransaction().commit();
```

2. **Gerenciamento de Transações**: O **EntityManager** é responsável por gerenciar o contexto de persistência dentro de uma transação. Ele deve ser utilizado dentro do escopo de uma transação, geralmente gerenciada por um container ou por transações manuais.

3. **Escopo de Vida**: O **EntityManager** é um objeto leve e de curto prazo. É criado e destruído frequentemente, normalmente para cada transação ou operação específica. Deve ser fechado após o uso.

   ```java
   em.close();
   ```

4. **Contexto de Persistência**: Ele fornece um contexto de persistência que gerencia o ciclo de vida das entidades, a sincronização com o banco de dados e o cache de primeiro nível (no nível da transação).


5. **Merge e Remove**: O método `merge` é usado para atualizar entidades, e `remove` para deletar entidades. O **EntityManager** também fornece métodos para verificar o estado da entidade e o gerenciamento do ciclo de vida da mesma.

Em resumo, **EntityManagerFactory** é responsável por criar e gerenciar **EntityManagers** e deve ser usado ao longo da vida da aplicação, enquanto o **EntityManager** é usado para interagir com a base de dados e deve ser criado e destruído conforme necessário, geralmente no escopo de uma transação.


# Atividade

## Utilizar o **@Enumerated**

1. Crie um Enum java com o nome TipoUsuarioEnum com 2 opções: COMUM e ADMINISTRADOR
2. Adicione o enum TipoUsuarioEnum como atributo na sua classe.
3. Adicione a anotação **@Enumerated** no novo atributo.
4. Adicione o parâmetro no enum: EnumType.ORDINAL execute o código
5. Adicione o parâmetro no enum: EnumType.STRING execute o código
6. Qual diferença entre os comandos de create table gerado?
7. Salve 1 usuário com o tipo COMUM 




