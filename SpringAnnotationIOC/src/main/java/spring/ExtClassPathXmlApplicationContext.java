package spring;

import annotation.ExtService;
import org.apache.commons.lang.StringUtils;
import utils.ClassUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 手写Spring专题 注解版本注入bean
 *
 * @author 作者:余胜军
 *
 */
public class ExtClassPathXmlApplicationContext {

    private String packageName;

    private ConcurrentHashMap<String, Object> beans;

    public ExtClassPathXmlApplicationContext(String packageName) {
        this.packageName = packageName;
    }

    // 扫包



    // getBean方法, 从beans里返回对象

    // 注解方式的依赖注入
    public void assignAttr(Object obj) {
        Class<?> clazz = obj.getClass();
//        clazz.getfie
    }

    // 初始化bean, 存到beans里, beanId对应bean对象
    public void initBean(ArrayList<Class> classesWithAnno) throws IllegalAccessException, InstantiationException {
        if (classesWithAnno == null)
            return;
        for (Class aClass : classesWithAnno) {
            // 创建对象
            Object newInstance = aClass.newInstance();
            // 拿到beanId, 类名的第一个字母小写
            String beanId = toLowerCaseFirstOne(aClass.getSimpleName());
            // 存到beans里
            beans.put(beanId, newInstance);
        }
    }

    // 使用反射机制获取该包下所有带有ExtService注解的类
    public ArrayList<Class> findClassWithExtServiceAnno() throws Exception {
        if (StringUtils.isEmpty(packageName))
            throw new Exception("扫包地址不能为空");

        // 1. 使用反射获取包路径下所有的类
        List<Class<?>> classes = ClassUtil.getClasses(packageName);

        // 2. 把有注解的类存起来
        ArrayList<Class> classesWithAnno = new ArrayList<>();

        // 3. 遍历类, 看有没有注解
        for (Class aClass : classesWithAnno) {
            ExtService extService = (ExtService) aClass.getDeclaredAnnotation(ExtService.class);
            if (extService != null)
                classesWithAnno.add(aClass);
        }
        return classesWithAnno;
    }


    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
