package run;




public class Main {

  public static void main(String[] args) {
    try {
      // System.setProperty(
      //   "java.util.logging.manager",
      //   "org.jboss.logmanager.LogManager"
      // );
      // Properties properties = new Properties();
      // properties.put(
      //   Context.INITIAL_CONTEXT_FACTORY,
      //   "org.wildfly.naming.client.WildFlyInitialContextFactory"
      // );
      // properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
      // // Initialisation du contexte JNDI: un service de gestion des noms
      // Context context = new InitialContext(properties);
      // // Recherche de l'EJB en utilisant le nom JNDI
      // String jndiName = "ejb:sante/sante/EjbFicheSante!ejb.FicheSanteRemote"; // le nom JNDI
      // FicheSanteRemote remote = (FicheSanteRemote) context.lookup(jndiName);

      // // Appel de méthodes de l'EJB
      // FicheSante result = remote.getFicheSante("CIN001");
      // System.out.println(result);
      // context.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
