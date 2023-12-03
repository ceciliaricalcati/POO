# Trabalho-POO
# Trabalho Final da disciplina de POO da faculdade 2023/2
O trabalho consiste em desenvolver novos elementos interativos para um jogo de aventura.
# - REQUISITOS:
# Implementação de novos elementos
Você deve desenvolver pelo menos 2 novos elementos para o mapa. Cada elemento deve ter:
- Uma representação visual única, definida por um símbolo e cor. Sugestão: pesquisar por símbolos interessantes na tabela de caracteres Unicode.
- Efeitos ou interações específicas com o personagem.
- Sugestões de elementos: obstáculos, itens colecionáveis, armadinhas, portais, NPCs (Non-Player Characters) com diálogos, etc.
- Exemplos de posicionamento no mapa.

# Implementação da ação de interação do personagem
Você deve implementar a ação de interagir do personagem. Atualmente o método interagir da classe Mapa apenas retorna uma mensagem genérica. Você deve implementar esse método para que funciona da seguinte forma:
- Pesquisar elementos interagíveis um raio de 2 célula de distância da posição atual do personagem;
- Chamar o interage() do elemento encontrado para obter a mensagem de interação;
- Caso seja encontrado mais de um elemento, priorizar o mais próximo e definir um critério padrão de desempate elementos com a mesma distância.
- Criar exemplos de posicionamento no mapa que permitam testar a funcionalidade.
- (Extra) Desenvolver mecânicas de interação entre o personagem e os novos elementos.
- (Extra) Fazer com que essas interações afetam o personagem e/ou o progresso no jogo.


