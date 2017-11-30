package com.firstspring.database.springdatabase.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.firstspring.database.springdatabase.bean.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int arg1) throws SQLException {
			Person person = new Person();
			person.setId(rs.getLong("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}

	}

	public Collection<Person> findAll() {
		return jdbcTemplate.query("SELECT * FROM PERSON", new PersonRowMapper());
	}

	public Person findById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE id = ?", new Object[] { id },
				new PersonRowMapper());
	}

	public int deleteById(Long id) {
		return jdbcTemplate.update("DELETE FROM PERSON WHERE id = ?", new Object[] { id });
	}

	public int insert(Person person) {
		return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (?, ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}

	public int update(Person person) {
		return jdbcTemplate.update("UPDATE PERSON SET NAME = ?, LOCATION = ?, BIRTH_DATE = ? WHERE ID = ?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });
	}

}
