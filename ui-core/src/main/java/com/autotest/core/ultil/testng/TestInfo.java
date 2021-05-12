package main.java.ultil.testng;

import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class TestInfo {

    public static final Map<Integer, String> STATUSES = Collections.unmodifiableMap(new TreeMap<Integer, String>() {
        private static final long serialVersionUID = 1L;

        {
            put(ITestResult.FAILURE, "Failure");
            put(ITestResult.SKIP, "Skip");
            put(ITestResult.STARTED, "Started");
            put(ITestResult.SUCCESS, "Success");
            put(ITestResult.SUCCESS_PERCENTAGE_FAILURE, "FailurePercentage");
        }
    });

    private TestInfo() {
    }

    /**
     * Get package + class + method name from ITestResult
     *
     * @param result from the fine-grained listener's method such as onTestFailure(ITestResult)
     * @return the package + class + method name in current context
     */
    public static String getPackageClassMethodName(ITestResult result) {
        return getContainingPackageName(result) + "." + getClassMethodName(result);
    }

    /**
     * Get class + method name from ITestResult
     *
     * @param result from the fine-grained listener's method such as onTestFailure(ITestResult)
     * @return the class + method name in current context
     */
    public static String getClassMethodName(ITestResult result) {
        return getClassName(result) + "." + getMethodName(result);
    }

    /**
     * Get method name from ITestResult
     *
     * @param result from the fine-grained listener's method such as onTestFailure(ITestResult)
     * @return the method name in current context
     */
    public static String getMethodName(ITestResult result) {
        return getMethodFromTestResult(result).getName();
    }

    /**
     * Get class name from ITestResult
     *
     * @param result from the fine-grained listener's method such as onTestFailure(ITestResult)
     * @return the class name in current context
     */
    public static String getClassName(ITestResult result) {
        Class<?> dClass = getMethodFromTestResult(result).getDeclaringClass();
        return dClass.getSimpleName();
    }

    /**
     * Get last containing package name from ITestResult
     *
     * @param result from the fine-grained listener's method such as onTestFailure(ITestResult)
     * @return the package name in current context
     */
    public static String getContainingPackageName(ITestResult result) {
        Package dPackage = getMethodFromTestResult(result).getDeclaringClass().getPackage();
        return dPackage.getName().replaceFirst("^.*\\.", "");
    }

    private static Method getMethodFromTestResult(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getMethod();
    }
}