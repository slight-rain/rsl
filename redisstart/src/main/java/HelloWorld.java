import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private static Logger logger= LoggerFactory.getLogger(HelloWorld.class);
    public static void main(String[] args) {
        IniRealm initReaml=new IniRealm("classpath:shiro.ini");
        SecurityManager sm=new DefaultSecurityManager(initReaml);
        SecurityUtils.setSecurityManager(sm);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("jack","12345");
        try {
            subject.login(token);
            System.out.println("登录成功");
            logger.info("登录成功");
        }catch(Exception e){
            logger.error("登录失败");
            e.printStackTrace();
        }
        subject.logout();
    }
}
