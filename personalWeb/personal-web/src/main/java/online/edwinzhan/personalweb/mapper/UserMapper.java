package online.edwinzhan.personalweb.mapper;

import online.edwinzhan.personalweb.entity.auth.Account;
import online.edwinzhan.personalweb.entity.user.AccountUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from db_account where username = #{text} or email = #{text}")
    Account findAccountByNameOrEmail(String text);

    @Select("select * from db_account where username = #{text} or email = #{text}")
    AccountUser findAccountUserByNameOrEmail(String text);

    @Insert("insert into db_account (username, password, email) values (#{username}, #{password}, #{email})")
    int createAccount(String username, String password, String email);

    @Update("update db_account set password = #{password} where email = #{email}")
    int resetPasswordByEmail(String password, String email);



}
