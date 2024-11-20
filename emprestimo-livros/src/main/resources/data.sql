/*INSERT INTO customer (id, name, lastname, adress, city, state, country, birth_date, status) VALUES
(1, 'Mateus', 'da Silva', 'Ponta da Praia', 'Santos', 'SP', 'Brasil', '2002-05-31', 'ACTIVE'),
(2, 'Marina', 'Camano', 'Macuco', 'Santos', 'SP', 'Brasil', '1998-12-15', 'ACTIVE'),
(3, 'Danrley', 'Regis', 'V. Enseada', 'Guaruja', 'SP', 'Brasil', '1998-07-21', 'ACTIVE'),
(4, 'Bianca', 'Zatorre', 'Canal 2', 'Santos', 'SP', 'Brasil', '1997-04-10', 'ACTIVE'),
(5, 'Gabriel', 'Bezerra', 'V. Formosa', 'Sao Paulo', 'SP', 'Brasil', '2004-01-13', 'ACTIVE'),
(6, 'Thiago', 'Wesley', 'Andorinha', 'Arapongas', 'PR', 'Brasil', '2006-01-28', 'ACTIVE'),
(7, 'Asuka', 'Langley', 'HQ Nerv', 'Tokyo-3', 'T-3', 'Japao', '2001-12-04', 'ACTIVE'),
(8, 'Shinji', 'Ikari', 'HQ Nerv', 'Tokyo-3', 'T-3', 'Japao', '2001-06-06', 'ACTIVE'),
(9, 'Rei', 'Ayanami', 'HQ Nerv', 'Tokyo-3', 'T-3', 'Japao', '2001-03-30', 'ACTIVE'),
(10, 'Misato', 'Katsuragi', 'HQ Nerv', 'Tokyo-3', 'T-3', 'Japao', '1986-12-08', 'ACTIVE');


INSERT INTO book (id, title, author, isbn, published_date, status) VALUES
(1, 'A Arte da Guerra: Edição de luxo Almofadado', 'SUN TZU ', '978-854280509399999', '2015-05-20', 'BORROWED'),
(2, 'Uma biografia da depressão', 'Christian Dunker', '978-6555352283', '2021-02-26', 'BORROWED'),
(3, 'O Clone de Cristo: Atos de Deus', 'James Beauseigneur', '978-8576790921', '2007-05-10', 'BORROWED'),
(4, 'O ego é seu inimigo: Como dominar seu pior adversário', 'Ryan Holiday', '978-8551002421', '2007-09-08', 'BORROWED'),
(5, 'O Anticristo', 'Friedrich Nietzsche', '978-8525417916', '2008-08-01', 'AVAILABLE'),
(6, 'Os segredos da mente milionária', 'T. Harv Eker', '978-8543109787', '2020-03-25', 'BORROWED'),
(7, 'Neon Genesis Evangelion: ANIMA Vol. 1', 'Ikuto Yamashita', '978-1642757088', '2019-08-22', 'AVAILABLE');


INSERT INTO loan (id, created_date, customer_id, author, isbn, published_date, completed_date, status) VALUES
(2, '2024-05-31', 8, 'Christian Dunker', '978-6555352283', '2021-02-26', '2024-06-14', 'BORROWED'),
(3, '2024-01-25', 9, 'James Beauseigneur', '978-8576790921', '2007-05-10', '2024-02-08', 'BORROWED'),
(4, '2024-02-28', 10, 'T. Harv Eker', '978-8543109787', '2020-03-25', '2024-03-13', 'BORROWED'),
(5, '2024-12-25', 7, 'Ryan Holiday', '978-8551002421', '2007-09-08', '2025-01-08', 'BORROWED');

INSERT INTO loan_books (loan_id, book_id) VALUES
(2, 2),
(3, 3),
(4, 6),
(4, 1),
(5, 4);*/
