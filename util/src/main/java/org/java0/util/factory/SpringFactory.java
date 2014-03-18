package org.java0.util.factory;

import java.util.Set;
import java.util.logging.Logger;

import org.java0.util.tag.Tag;

@SuppressWarnings("unused")
public class SpringFactory extends AbstractFactory {

    /**
     * @see org.java0.util.factory.Factory#getObject(java.lang.Class, org.java0.util.tag.Tag)
     */
    @Override
    public <T> T getObject(Class<T> type, Tag tag)
            throws FactoryException {
        return null;
    }


    // @Inject
    // private ApplicationContext context;
    //
    // @Inject
    // private ConfigurableListableBeanFactory factory;
    //
    // public SpringFactory() {
    // }
    //
    // @Override
    // public String getName() {
    // return SpringFactory.class.getName();
    // }
    //
    // @SuppressWarnings("unchecked")
    // @Override
    // public <T> T getObject(Class<T> type, Object... constructorArgs) {
    // logger.entering(SpringFactory.class.getName(), "getObject",
    // constructorArgs);
    //
    // String[] names = context.getBeanNamesForType(type);
    //
    // if (names.length > 1) {
    // logger.fine("Resolving ambiguous bean declaration for type "
    // + type.getName());
    //
    // // Ridiculously inefficient
    // List<String> namesList = new ArrayList<String>(Arrays.asList(names));
    //
    // for (Iterator<String> i = namesList.iterator(); i.hasNext();) {
    // String name = i.next();
    //
    // BeanDefinition beanDef = factory.getBeanDefinition(name);
    // logger.fine("Bean name: " + name
    // + ", Bean class: " + beanDef.getBeanClassName());
    //
    // String className = beanDef.getBeanClassName();
    //
    // try {
    // boolean match = false;
    //
    // Class<?> cls = Class.forName(className);
    //
    // Type[] interfaceTypes = cls.getGenericInterfaces();
    // for (Type interfaceType : interfaceTypes) {
    // logger.fine("Bean directly implements type "
    // + interfaceType.toString());
    // if (interfaceType == type) {
    // logger.info("Interface type matches requested type");
    // match = true;
    // }
    // }
    //
    // if (cls.getSuperclass() == type) {
    // logger.fine("Direct superclass of type matches requested type");
    // match = true;
    // }
    //
    // if (match == true) {
    // logger.fine("Class "
    // + className
    // + " directly implements or extends requested type");
    // } else {
    // logger.fine("Class "
    // + className
    // + " does not directly implement or extend requested type");
    // i.remove();
    // }
    //
    // } catch (ClassNotFoundException e) {
    // throw LogUtil.log(logger, new FactoryException(
    // "Caught exception in auto-generated catch block", e));
    // }
    // }
    //
    // if (namesList.size() != 1) {
    // throw LogUtil
    // .log(logger,
    // new FactoryException(
    // "Unabled to resolve requested type to a single bean definition"));
    // }
    //
    // } else if (names.length == 0) {
    // throw LogUtil.log(logger, new UnknownTypeException(
    // "No beans found for type " + type.getName()));
    // }
    //
    // if (constructorArgs.length > 0) {
    // return (T) context.getBean(names[0], constructorArgs);
    // } else {
    // return (T) context.getBean(names[0]);
    // }
    // }
}
