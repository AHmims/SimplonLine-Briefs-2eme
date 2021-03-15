package util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

//https://stackoverflow.com/a/47934704/14427192
public class PkGenerator implements IdentifierGenerator {
    public static final String rndmString = "pkGenerator";
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
