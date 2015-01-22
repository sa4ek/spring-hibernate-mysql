package org.krams.tutorial.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krams.tutorial.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service for processing Persons
 * Сервис для класса Person
 */
@Service("personService")
@Transactional
public class PersonService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all persons
     * Получает лист всех персон
     * @return a list of persons
     */
    public List<Person> getAll() {
        logger.debug("Retrieving all persons");

        // Retrieve session from Hibernate
        // Получаем сессию
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        // Создаем запрос
        Query query = session.createQuery("FROM  Person");

        // Retrieve all
        // получаем всех
        return  query.list();
    }

    /**
     * Retrieves a single person
     * Получение одной персоны
     */
    public Person get( Integer id ) {
        // Retrieve session from Hibernate
        // получаем сессию
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        // получаем персону по id
        Person person = (Person) session.get(Person.class, id);

        return person;
    }
    /**
     * Adds a new person
     *  Добавление персоны
     */
    public void add(Person person) {
        logger.debug("Adding new person");

        // Retrieve session from Hibernate
        // получаем сессию
        Session session = sessionFactory.getCurrentSession();

        // Save
        // сохраняем
        session.save(person);
    }

    /**
     * Deletes an existing person
     * Удаление существующей персоны
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        logger.debug("Deleting existing person");

        // Retrieve session from Hibernate
        // получаем сессию
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        // получаем существующую персону
        Person person = (Person) session.get(Person.class, id);

        // Delete
        // удаляем
        session.delete(person);
    }

    /**
     * Edits an existing person
     * Правка персоны
     */
    public void edit(Person person) {
        logger.debug("Editing existing person");

        // Retrieve session from Hibernate
        // как всегда получаем сессию
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person via id
        // получаем существующую персону по id
        Person existingPerson = (Person) session.get(Person.class, person.getId());

        // Assign updated values to this person
        // обновляем значения
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(existingPerson.getLastName());
        existingPerson.setMoney(existingPerson.getMoney());

        // Save updates
        // сохраняем изменения
        session.save(existingPerson);
    }
}
