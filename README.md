# Automatização de contratos

Trata-se de um sistema criado para automatizar o processo de contratos de uma empresa fictícia, que consiste em __gerar as parcelas__ a serem pagas para aquele contrato, com base no número de meses desejado.

O programa lê os dados de um contrato e o número de meses de parcelamento e gera os registros de parcelas a serem pagas (data e valor), sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois meses após o contrato e assim por diante. Além disso, como os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa por pagamento, é aplicado um juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.

Por fim, ao calcular as parcelas e datas, é criado automaticamente um __arquivo txt__ contendo todas essas informações.


