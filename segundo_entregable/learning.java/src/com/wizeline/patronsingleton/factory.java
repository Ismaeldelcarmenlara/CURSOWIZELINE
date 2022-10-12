package com.wizeline.patronsingleton;

public class factory {

    private static final Logger LOG = Logger.getLogger(ProcesaTipoServicio.class.getName());

    public ServiceProcessing procesaTipoServicio(HttpServer server, String path) {

        if (server != null && path != null) {
            switch (path) {
                case "/api/login":
                    LOG.info("procesandoservicio login");
                    return new Login();

                case "/api/createUser":
                    LOG.info("proceso de  createUser");
                    return new CreateUser();

                case "/api/getUserAccount":
                    LOG.info("proceso de  getUserAccount");
                    return new GetUserAccount();

                case "/api/getAccounts":
                    LOG.info("proceso de  getAccounts");
                    return new GetAccounts();

                default:
                    throw new ExcepcionGenerica("Opciones no diponibles");

            }
        } else {
            throw new ExcepcionGenerica("Problema al procesar peticion");
        }
    }
}
