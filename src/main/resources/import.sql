-- Inserindo 10 Categorias
INSERT INTO category (id, name) VALUES (1, 'Eletrônicos');
INSERT INTO category (id, name) VALUES (2, 'Livros');
INSERT INTO category (id, name) VALUES (3, 'Computadores');
INSERT INTO category (id, name) VALUES (4, 'Casa e Decoração');
INSERT INTO category (id, name) VALUES (5, 'Esportes');
INSERT INTO category (id, name) VALUES (6, 'Moda');
INSERT INTO category (id, name) VALUES (7, 'Beleza e Perfumaria');
INSERT INTO category (id, name) VALUES (8, 'Brinquedos');
INSERT INTO category (id, name) VALUES (9, 'Automotivo');
INSERT INTO category (id, name) VALUES (10, 'Ferramentas');

-- Inserindo 20 Produtos
INSERT INTO product (id, name, description, price, img_url) VALUES (1, 'Smartphone Galaxy', 'Smartphone de última geração com 128GB', 2599.99, 'https://example.com/img/prod1.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (2, 'Notebook Pro', 'Notebook para desenvolvedores e profissionais', 5499.00, 'https://example.com/img/prod2.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (3, 'Smart TV 4K', 'TV de 55 polegadas com resolução 4K', 3200.50, 'https://example.com/img/prod3.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (4, 'Livro Código Limpo', 'Um guia clássico para desenvolvimento ágil', 95.90, 'https://example.com/img/prod4.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (5, 'Livro Senhor dos Anéis', 'Edição especial de volume único', 120.00, 'https://example.com/img/prod5.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (6, 'Cadeira Gamer', 'Cadeira ergonômica com ajuste de altura', 850.00, 'https://example.com/img/prod6.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (7, 'Monitor Ultrawide', 'Monitor de 29 polegadas ideal para produtividade', 1450.00, 'https://example.com/img/prod7.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (8, 'Teclado Mecânico', 'Teclado mecânico RGB switch blue', 320.00, 'https://example.com/img/prod8.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (9, 'Mouse Sem Fio', 'Mouse ergonômico de alta precisão', 150.00, 'https://example.com/img/prod9.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (10, 'Jogo de Panelas', 'Conjunto de panelas antiaderentes com 5 peças', 400.00, 'https://example.com/img/prod10.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (11, 'Aspirador Robô', 'Aspirador inteligente que limpa e passa pano', 1100.00, 'https://example.com/img/prod11.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (12, 'Bicicleta Aro 29', 'Bicicleta de montanha com freio a disco', 1250.00, 'https://example.com/img/prod12.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (13, 'Tênis de Corrida', 'Calçado com sistema de amortecimento avançado', 550.00, 'https://example.com/img/prod13.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (14, 'Camiseta de Algodão', 'Camiseta básica 100% algodão', 49.90, 'https://example.com/img/prod14.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (15, 'Perfume Essencial', 'Fragrância amadeirada intensa', 210.00, 'https://example.com/img/prod15.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (16, 'Jogo de Tabuleiro', 'Jogo de estratégia para toda a família', 230.00, 'https://example.com/img/prod16.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (17, 'Quebra-cabeça 1000 peças', 'Desafio relaxante com paisagem noturna', 85.00, 'https://example.com/img/prod17.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (18, 'Caixa de Ferramentas', 'Kit completo com 110 peças variadas', 280.00, 'https://example.com/img/prod18.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (19, 'Furadeira de Impacto', 'Equipamento de 710W com controle de velocidade', 190.00, 'https://example.com/img/prod19.jpg');
INSERT INTO product (id, name, description, price, img_url) VALUES (20, 'Óleo de Motor', 'Óleo sintético para carros de passeio', 45.00, 'https://example.com/img/prod20.jpg');

-- Associando Produtos às Categorias (Tabela de Junção product_categories)
INSERT INTO product_categories (product_id, category_id) VALUES (1, 1); -- Smartphone -> Eletrônicos
INSERT INTO product_categories (product_id, category_id) VALUES (2, 1); -- Notebook -> Eletrônicos
INSERT INTO product_categories (product_id, category_id) VALUES (2, 3); -- Notebook -> Computadores
INSERT INTO product_categories (product_id, category_id) VALUES (3, 1); -- Smart TV -> Eletrônicos
INSERT INTO product_categories (product_id, category_id) VALUES (4, 2); -- Código Limpo -> Livros
INSERT INTO product_categories (product_id, category_id) VALUES (4, 3); -- Código Limpo -> Computadores
INSERT INTO product_categories (product_id, category_id) VALUES (5, 2); -- Senhor dos Anéis -> Livros
INSERT INTO product_categories (product_id, category_id) VALUES (6, 3); -- Cadeira Gamer -> Computadores
INSERT INTO product_categories (product_id, category_id) VALUES (6, 4); -- Cadeira Gamer -> Casa e Decoração
INSERT INTO product_categories (product_id, category_id) VALUES (7, 1); -- Monitor -> Eletrônicos
INSERT INTO product_categories (product_id, category_id) VALUES (7, 3); -- Monitor -> Computadores
INSERT INTO product_categories (product_id, category_id) VALUES (8, 1); -- Teclado -> Eletrônicos
INSERT INTO product_categories (product_id, category_id) VALUES (8, 3); -- Teclado -> Computadores
INSERT INTO product_categories (product_id, category_id) VALUES (9, 1); -- Mouse -> Eletrônicos
INSERT INTO product_categories (product_id, category_id) VALUES (9, 3); -- Mouse -> Computadores
INSERT INTO product_categories (product_id, category_id) VALUES (10, 4); -- Jogo de Panelas -> Casa e Decoração
INSERT INTO product_categories (product_id, category_id) VALUES (11, 1); -- Aspirador Robô -> Eletrônicos
INSERT INTO product_categories (product_id, category_id) VALUES (11, 4); -- Aspirador Robô -> Casa e Decoração
INSERT INTO product_categories (product_id, category_id) VALUES (12, 5); -- Bicicleta -> Esportes
INSERT INTO product_categories (product_id, category_id) VALUES (13, 5); -- Tênis -> Esportes
INSERT INTO product_categories (product_id, category_id) VALUES (13, 6); -- Tênis -> Moda
INSERT INTO product_categories (product_id, category_id) VALUES (14, 6); -- Camiseta -> Moda
INSERT INTO product_categories (product_id, category_id) VALUES (15, 7); -- Perfume -> Beleza e Perfumaria
INSERT INTO product_categories (product_id, category_id) VALUES (16, 8); -- Jogo de Tabuleiro -> Brinquedos
INSERT INTO product_categories (product_id, category_id) VALUES (17, 8); -- Quebra-cabeça -> Brinquedos
INSERT INTO product_categories (product_id, category_id) VALUES (18, 10); -- Caixa de Ferramentas -> Ferramentas
INSERT INTO product_categories (product_id, category_id) VALUES (19, 10); -- Furadeira -> Ferramentas
INSERT INTO product_categories (product_id, category_id) VALUES (20, 9); -- Óleo de Motor -> Automotivo