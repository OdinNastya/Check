# Тестовое задание
___
### В проекте имеются три класса:

---
* ____CheckRunner____

    Методы:
   * main
     >Выполняет запуск программы, создание объекта и вызова методов других классов.Вызов selectionItem, checkId, newArray, readingFile
    * readingFile
      >Чтение из файла входных данных
    * selectionItem
      >Выбор пунктов меню.
---
* ___DataBase___

    Методы:
  * createArray
    >Заполнение двух HashMap .
    >>identify – id и наименование товара
    >>cost - наименование товара и стоимость
  * ArrayList cardBase
    >Заполнение скидочных карт
  * Title
    >Формирование заголовка чека

---
* ___Check___

  Методы:
  * newArray
    >Принимает значения метода checkId и метода card.Преобразует входные данные для расчёта стоимости. При это расчеты записываются по строчке в listWrTotal и отображаются в терминале.
  * checkId
    >Считывает входные данные, проверяет на правильность ввода и возвращает строку.
  * card
    >Возвращает Boolean значение. Проверяется имеется ли скидочная карта у пользователя и проверяется на наличие ее в базе.
  * getSizeStr(String str,Integer x)
  * getSizeStr(Double str,Integer x)
    >>Методы для оформления чека. Добавления пробелов. (Можно было реализовать с использованием специальной функции)

