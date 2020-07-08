import com.bj58.spring.di.service.IAccountService;
import com.bj58.spring.di.service.impl.AccountServiceImpl;
import javafx.beans.binding.ObjectExpression;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AccountServiceTest extends BaseTest{
        @Resource
        private IAccountService accountService;

        @Test
        public void  saveAccount(){

           IAccountService accountService = new AccountServiceImpl();
            IAccountService serviceProxy = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                    accountService.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Object value = method.invoke( accountService, (Integer) args[0]* 2 );
                        return value;
                       }
                    });
            serviceProxy.saveAccount(1000);
        }
}
