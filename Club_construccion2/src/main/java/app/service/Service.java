package app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.config.MYSQLConnection;
import app.dao.UserDaoImplementation;
import app.dao.Interfaces.UserDao;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.interfaces.LoginService;

public class Service implements LoginService{
    private UserDao userDao;
	
	private MYSQLConnection connection = new MYSQLConnection();
    public static UserDto user;

    public Service() {
		this.userDao = new UserDaoImplementation();
    }

    @Override
	public void login(UserDto userDto) throws Exception {
		UserDto validateDto = userDao.findByUserName(userDto);
		if (validateDto == null) {
			throw new Exception("no existe usuario registrado");
		}
		// if (!userDto.getPassword().equals(validateDto.getPassword())) {
		// 	throw new Exception("usuario o contraseña incorrecto");
		// }
		userDto.setRol(validateDto.getRol());
		user = validateDto;
	}

	@Override
	public void logout() {
		user = null;
		System.out.println("se ha cerrado sesion");
	}

	@Override
	public void createUser(UserDto user){
		Connection conn = null;
    	PreparedStatement pstmt = null;
		ResultSet generatedKeys = null;
		PersonDto person = user.getPersonId();
		String sql = "INSERT INTO person (DOCUMENT, NAME, CELLPHONE) VALUES (?, ?, ?)";
		try {
        conn = connection.getConnection(); 
        pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, person.getCedula());
        pstmt.setString(2, person.getName());
        pstmt.setString(3, person.getCelPhone());
        int rowsInserted = pstmt.executeUpdate();

        if (rowsInserted > 0) {
            generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                sql = "INSERT INTO user (PERSONNID, USERNAME, PASSWORD, ROLE) VALUES (?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.setString(2, user.getUserName());
				pstmt.setString(3, user.getPassword());
				pstmt.setString(4, user.getRol());
				rowsInserted = pstmt.executeUpdate();
            } else {
                System.out.println("No se pudo obtener el ID generado.");
            }
        } else {
            System.out.println("No se insertó ningún registro.");
        }

    } catch (SQLException e) {
			e.printStackTrace();
        	// throw new Exception("Error al insertar el usuario: " + e.getMessage(), e);
		}

	}


	// crear un metodo que verifique que no haya un id de usuario repetido 
	
    
}
