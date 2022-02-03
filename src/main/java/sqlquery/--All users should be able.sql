--All users should be able
SELECT *
FROM library.books;

--this books are available in library
SELECT library."logBook"."idBook"
FROM library."logBook"
WHERE ("logBook"."dataOut" IS  NOT NULL) AND ("logBook"."dateIn" IS NOT NULL);

--this books are not available in library
SELECT library."logBook"."idBook"
FROM library."logBook"
WHERE (NOT ("logBook"."dataOut" IS NULL) AND ("logBook"."dateIn" IS NULL));

SELECT *
FROM library.authors
WHERE name = 'Theodore'
  AND surname = 'Dreiser';

SELECT *
FROM library.books
WHERE title = 'Java';

--get most popular
SELECT "idBook", COUNT(*)
FROM library."logBook"
GROUP BY "idBook" ORDER BY count(*) DESC ;

--get most unpopular
SELECT "idBook", COUNT(*)
FROM library."logBook"
GROUP BY "idBook"
ORDER BY count(*) ASC;

--get most popular in selected period
SELECT "idBook", COUNT(*)
FROM library."logBook"
WHERE "dataOut" = '2022-12-07'
  AND "dateIn" = '2022-01-04'
GROUP BY "idBook"
ORDER BY count(*) DESC;

--get most unpopular in selected period
SELECT "idBook", COUNT(*)
FROM library."logBook"
WHERE "dataOut" = '2022-12-07'
  AND "dateIn" = '2022-01-04'
GROUP BY "idBook"
ORDER BY count(*) ASC;

--Reader should be able
--request needed books(request books by author)
select "name", "surname", "title", "yearProduction"
from library.books b
         join library.authors bA on b.id = bA.id
where name = 'David'
  and surname = 'Gery';

--return book


--get statics
SELECT "idUser", "idBook", "dataOut", "dateIn", count(*)
FROM library."logBook"
WHERE "idUser" = 2
GROUP BY "idBook", "idUser", "dataOut", "dateIn";