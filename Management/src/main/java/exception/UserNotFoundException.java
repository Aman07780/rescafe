package exception;

public class UserNotFoundException extends RuntimeException{

	String resourceName;
	String fileName;
	long fieldValue;
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	public UserNotFoundException(String resourceName, String fileName, long fieldValue) {
		super(String.format("%s not found with %s : %s",resourceName,fileName,fieldValue));
		this.resourceName = resourceName;
		this.fileName = fileName;
		this.fieldValue = fieldValue;
	}
	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
