# Projeto CadastroPOO

## Visão Geral

O projeto CadastroPOO é um sistema de cadastro de pessoas físicas e jurídicas desenvolvido em Java utilizando o paradigma de Programação Orientada a Objetos (POO). O sistema permite realizar operações básicas como inclusão, alteração, exclusão, exibição por ID, exibição de todos os registros, além de salvar e recuperar os dados de forma persistente em arquivos.

## Componentes Principais

### Classes

1. **Pessoa**: Classe base que representa uma pessoa com atributos comuns como ID e Nome.
   
   - **Atributos**:
     - `id`: Identificador único da pessoa.
     - `nome`: Nome da pessoa.
   
   - **Métodos**:
     - `getId()`: Retorna o ID da pessoa.
     - `getNome()`: Retorna o nome da pessoa.
     - `setId(int id)`: Define o ID da pessoa.
     - `setNome(String nome)`: Define o nome da pessoa.
     - `toString()`: Retorna uma representação textual da pessoa.

2. **PessoaFisica**: Subclasse de `Pessoa` que adiciona atributos específicos para pessoas físicas como CPF e idade.
   
   - **Atributos Adicionais**:
     - `cpf`: CPF da pessoa física.
     - `idade`: Idade da pessoa física.
   
   - **Métodos Adicionais**:
     - `getCpf()`: Retorna o CPF da pessoa física.
     - `setIdade(int idade)`: Define a idade da pessoa física.
     - `toString()`: Sobrescreve o método `toString()` para incluir CPF e idade.

3. **PessoaJuridica**: Subclasse de `Pessoa` que adiciona atributos específicos para pessoas jurídicas como CNPJ.
   
   - **Atributos Adicionais**:
     - `cnpj`: CNPJ da pessoa jurídica.
   
   - **Métodos Adicionais**:
     - `getCnpj()`: Retorna o CNPJ da pessoa jurídica.
     - `toString()`: Sobrescreve o método `toString()` para incluir CNPJ.

4. **PessoaFisicaRepo**: Repositório para armazenar e gerenciar objetos do tipo `PessoaFisica`.
   
   - **Métodos Principais**:
     - `inserir(PessoaFisica pessoa)`: Insere uma nova pessoa física no repositório.
     - `alterar(PessoaFisica pessoa)`: Altera os dados de uma pessoa física existente no repositório.
     - `excluir(int id)`: Exclui uma pessoa física do repositório com base no ID.
     - `obter(int id)`: Retorna uma pessoa física do repositório com base no ID.
     - `obterTodos()`: Retorna uma lista contendo todas as pessoas físicas cadastradas.
     - `persistir(String nomeArquivo)`: Salva os dados das pessoas físicas em um arquivo binário.
     - `recuperar(String nomeArquivo)`: Recupera os dados das pessoas físicas de um arquivo binário.

5. **PessoaJuridicaRepo**: Repositório para armazenar e gerenciar objetos do tipo `PessoaJuridica`.
   
   - **Métodos Principais**:
     - `inserir(PessoaJuridica pessoa)`: Insere uma nova pessoa jurídica no repositório.
     - `alterar(PessoaJuridica pessoa)`: Altera os dados de uma pessoa jurídica existente no repositório.
     - `excluir(int id)`: Exclui uma pessoa jurídica do repositório com base no ID.
     - `obter(int id)`: Retorna uma pessoa jurídica do repositório com base no ID.
     - `obterTodos()`: Retorna uma lista contendo todas as pessoas jurídicas cadastradas.
     - `persistir(String nomeArquivo)`: Salva os dados das pessoas jurídicas em um arquivo binário.
     - `recuperar(String nomeArquivo)`: Recupera os dados das pessoas jurídicas de um arquivo binário.

### Funcionalidades

- **Inclusão**: Permite adicionar novas pessoas físicas ou jurídicas ao sistema.
- **Alteração**: Permite modificar os dados de uma pessoa física ou jurídica existente.
- **Exclusão**: Permite remover uma pessoa física ou jurídica do sistema com base no ID.
- **Exibição por ID**: Permite visualizar os detalhes de uma pessoa específica com base no ID.
- **Exibição de Todos**: Lista todas as pessoas físicas e jurídicas cadastradas no sistema.
- **Salvar Dados**: Persiste os dados das pessoas físicas e jurídicas em arquivos binários.
- **Recuperar Dados**: Recupera os dados das pessoas físicas e jurídicas previamente salvos.

## Utilização

O sistema é utilizado através de um menu interativo no console, onde o usuário pode escolher as operações desejadas (incluir, alterar, excluir, etc.) digitando o número correspondente à opção desejada.

## Observações

- O sistema utiliza serialização/deserialização para persistir os dados em arquivos binários. Certifique-se de que os arquivos de dados (`pessoasFisicas.bin` e `pessoasJuridicas.bin`) estejam acessíveis e com permissões de escrita adequadas no diretório de execução do programa.
