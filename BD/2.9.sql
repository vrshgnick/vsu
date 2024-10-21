--Группа: 7.1
--ФИО: Верещагин Николай Евгеньевич
--2.9

-- Формирование связанных подзапросов

/*ответы:  
1. - 1, зиновьев  
2. - 4312  
3. - 290  
4. - биология математика литр, рус и литра  
5. - 2665  
6. - 158  
7. - 69  
8. - 18  
9. - 149  
10. - 4384,  
11. - 353  
12. - 117  
ТИПОВЫЕ ОШИБКИ  
10. - или знак, или MAX , а также считают неудовлетв. оценкой только 2  
12. - distinct  
*/

--2.9.1

--Напишите запрос для получения списка студентов, которые учат-

--ся в своем городе.

  

	SELECT *
	FROM STUDENT s
	WHERE CITY = (
	SELECT CITY
	FROM UNIVERSITY u
	WHERE u.UNIV_ID = s.UNIV_ID);

--2.9.2

--Напишите запрос для получения списка иногородних студентов

--(обучающихся не в своем городе), с последующей сортировкой по

--идентификаторам университетов и курсам.

  
	SELECT *
	FROM STUDENT s
	WHERE CITY <> (
	SELECT CITY
	FROM UNIVERSITY u
	WHERE u.UNIV_ID = s.UNIV_ID)
	ORDER BY UNIV_ID, KURS;

  

--2.9.3

--Напишите запрос для получения списка преподавателей, работа-

--ющих не в своем городе, с последующей сортировкой по иденти-

--фикаторам университетов и городам проживания преподавателей.

  

	SELECT *
	FROM LECTURER l
	WHERE CITY <> (
	SELECT CITY
	FROM UNIVERSITY u
	WHERE u.UNIV_ID = l.UNIV_ID)
	ORDER BY UNIV_ID, CITY;

  

--2.9.4

--Напишите запрос для получения списка предметов, на изучение

--которых отведено максимальное количество часов среди всех

--предметов, изучаемых в том же семестре. Список упорядочить по

--семестрам.

  

	SELECT *
	FROM SUBJECT s1
	WHERE HOUR = (
	SELECT MAX(HOUR)
	FROM SUBJECT s2
	WHERE s1.SEMESTER = s2.SEMESTER)
	ORDER BY SEMESTER;

  

--2.9.5

--Напишите запрос для получения списка студентов, получающих

--стипендию, превосходящую среднее значение стипендии на их

--курсе.

  

	SELECT *
	FROM STUDENT s1
	WHERE STIPEND > (
	SELECT AVG(STIPEND)
	    FROM STUDENT s2
	        WHERE s1.KURS = s2.KURS);

--2.9.6

--Напишите запрос для получения списка студентов, получающих

--минимальную стипендию в своем университете, с последующей

--сортировкой по значениям идентификатора университета и сти-

--пендии.

  

	SELECT *
	FROM STUDENT s1
	WHERE STIPEND = (
	SELECT MIN(STIPEND)
	FROM STUDENT s2
	WHERE s1.UNIV_ID = s2.UNIV_ID)
	ORDER BY UNIV_ID, STIPEND;

  

--2.9.7

--Напишите запрос для получения списка университетов, в кото-

--рых учится более 50 студентов, с последующей сортировкой по

--рейтингам.

  

	SELECT *
	FROM UNIVERSITY
	WHERE UNIV_ID IN (
	SELECT UNIV_ID
	FROM STUDENT
	GROUP BY UNIV_ID
	HAVING COUNT(STUDENT_ID) > 50)
	ORDER BY RATING;

  

--2.9.8

--Напишите запрос для получения списка университетов, в кото-

--рых работает более 5 преподавателей, с последующей сортиров-

--кой по рейтингам университетов.

  

	SELECT *
	FROM UNIVERSITY
	WHERE UNIV_ID IN (
	SELECT UNIV_ID
	FROM LECTURER
	GROUP BY UNIV_ID
	HAVING COUNT(LECTURER_ID) > 5)
	ORDER BY RATING;

  

--2.9.9

--Напишите запрос для получения списка отличников (студентов,

--получивших только отличные оценки), с последующей сортиров-

--кой по идентификаторам университетов и курсам.

  

	SELECT *
	FROM STUDENT s
	WHERE (
	SELECT MIN(MARK)
	FROM EXAM_MARKS e
	WHERE e.STUDENT_ID = s.STUDENT_ID) = 5
	ORDER BY UNIV_ID, KURS;

  

--2.9.10

--Напишите запрос для получения списка неуспевающих студен-

--тов (получивших хотя бы одну неудовлетворительную оценку), с

--последующей сортировкой по идентификаторам университетов и

--курсам.

  

	SELECT *
	FROM STUDENT s
	WHERE (
	SELECT MIN(MARK)
	FROM EXAM_MARKS e
	WHERE e.STUDENT_ID = s.STUDENT_ID) IN (0, 1, 2)
	ORDER BY UNIV_ID, KURS;

  

--2.9.11

--Напишите запрос, выполняющий вывод списка студентов, сред

--няя оценка которых превышает 4 балла.

  

	SELECT *
	FROM STUDENT
	WHERE STUDENT_ID IN (
	SELECT STUDENT_ID
	FROM EXAM_MARKS
	GROUP BY STUDENT_ID
	HAVING AVG(MARK) > 4);

--2.9.12

--Напишите запрос, выполняющий вывод списка фамилий студен-

--тов, имеющих только отличные оценки и проживающих в городе,

--не совпадающем с городом их университета.

  

	SELECT DISTINCT(SURNAME)
	FROM STUDENT s
	WHERE (
	SELECT MIN(MARK)
	FROM EXAM_MARKS e
	WHERE e.STUDENT_ID = s.STUDENT_ID) = 5 AND CITY <> (
	SELECT CITY
	FROM UNIVERSITY u
	WHERE u.UNIV_ID = s.UNIV_ID);