import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements CalculatorInterface {

    public CalculatorServer() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    @Override
    public int subtract(int x, int y) throws RemoteException {
        return x - y;
    }

    @Override
    public int multiply(int x, int y) throws RemoteException {
        return x * y;
    }

    @Override
    public double divide(int x, int y) throws RemoteException {
        if (y == 0) throw new ArithmeticException("Cannot divide by zero");
        return (double) x / y;
    }

    public static void main(String[] args) {
        try {
            CalculatorServer server = new CalculatorServer();
            Naming.rebind("rmi://localhost:5000/calc", server);
            System.out.println("RMI Calculator server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
