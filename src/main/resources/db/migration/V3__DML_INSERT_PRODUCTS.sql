insert into product (code, name, type_id, price, available, registry_date, last_update)
values
('XB21-4C', 'Contra Baixo Tagima XB21 4C', (select id from type where name = 'INSTRUMENTO'), 999.90, true, now(), now()),
('BD1-4C', 'Contra Baixo SX BD1 4C', (select id from type where name = 'INSTRUMENTO'), 899.90, true, now(), now()),
('Lps-230', 'Guitarra Les Paul Lps-230', (select id from type where name = 'INSTRUMENTO'), 1179.90, true, now(), now()),
('BM800', 'Microfone BM800', (select id from type where name = 'ACESSORIO'), 169.90, true, now(), now()),
('SCAR_SOLO3', 'Interface de Audio Scarlett Solo 3', (select id from type where name = 'ACESSORIO'), 1199.90, true, now(), now()),
('4C-CB', 'Kit 4 Cordas Contra Baixo', (select id from type where name = 'ACESSORIO'), 119.90, true, now(), now()),
('6C-CB', 'Kit 6 Cordas Guitarra', (select id from type where name = 'ACESSORIO'), 99.90, true, now(), now());