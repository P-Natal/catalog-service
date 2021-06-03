insert into product (name, type, price, active)
values
('Contra Baixo Tagima XB21 4C', (select id from type where name = 'INSTRUMENTO'), 99990, true),
('Contra Baixo SX BD1 4C', (select id from type where name = 'INSTRUMENTO'), 89990, true),
('Guitarra Les Paul Lps-230', (select id from type where name = 'INSTRUMENTO'), 117990, true),
('Microfone BM800', (select id from type where name = 'ACESSORIO'), 16990, true),
('Interface de Audio Scarlett Solo 3', (select id from type where name = 'ACESSORIO'), 119990, true),
('Kit 4 Cordas Contra Baixo', (select id from type where name = 'ACESSORIO'), 11990, true),
('Kit 6 Cordas Guitarra', (select id from type where name = 'ACESSORIO'), 9990, true);