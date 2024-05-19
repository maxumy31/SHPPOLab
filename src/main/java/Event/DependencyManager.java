package Event;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyManager
{
    static ProxyEventBuilder builder;

    public DependencyManager(ProxyEventBuilder b)
    {
        if(builder == null)
        {
            builder = b;
            builder.setNewBuilder();
        }
    }

    public IProxyBuilder getBuilder()
    {
        if(builder == null)
        {
            updateDependencies();
        }
        return builder;
    }

    public void updateDependencies()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        builder = (ctx.getBean("proxyEventBuilder",ProxyEventBuilder.class));
        builder.setNewBuilder();
        ctx.close();
    }
}
