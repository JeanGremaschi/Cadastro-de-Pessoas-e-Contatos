# Cadastro-de-Pessoas-e-Contatos
Crud de cadastro de pessoas e seus contatos

### Mapeamento:

   listarPessoas: ``
   /listarPessoas``
    
   listarContatos:``
   /listarContatos``
   
   listarPorId:``
   /listarPessoa/{id}``
   
   listarContatosPorPessoa:``
   /listarPessoa/{id}/listarContatos``
   
   cadastrar:``
   /cadastrar``
      
   atualizar:``
   /atualizar/{id}``
   
   deletar:``
   /deletar/{id}``
   
   ### Json para cadastro:
   ``{
    "nome": "Rafael",
    "cpf": "24415884008",
    "dataNascimento": "2002-05-18",
    "contatos": [{
            "nome": "João",
            "telefone": "44 99889988",
            "email": "email@dominio.com"
        }, {
            "nome": "Ana",
            "telefone": "44 88998899",
            "email": "email@dominio.com"
        }]
}``

## Link para importação no Postman (Local)
``https://www.getpostman.com/collections/e2fe39d9338601e41e83``

## Link para importação no Postman (Heroku)
``https://www.getpostman.com/collections/f94a17a7919975ebff7e``

https://cadastro12846.herokuapp.com
