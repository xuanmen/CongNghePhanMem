package ltdt;

import java.util.ArrayList;

public class DoThiVoHuong {
	private static int numVertice;
	private Point point;
	private int[][] adjacentMatrix;
	private static ArrayList<String> edgeList;
	private static ArrayList<Point> arrayListPoint;

	public DoThiVoHuong() {
		edgeList = new ArrayList<String>();
		arrayListPoint = new ArrayList<Point>();
	}

	/*--PHUONG THUC NHAP CAC DINH VAO------------------------------------------------------------------------*/
	public boolean addVertice(String verticeName, int x, int y) {
		if (verticeName.length() >= 2)
			return false;
		boolean result = false;
		try {
			point = new Point(verticeName, x, y);
			arrayListPoint.add(point);
			result = true;
		} catch (Exception e) {
		}

		return result;
	}

	/*--PHUONG THUC NHAP CAC CANH VAO------------------------------------------------------------------------*/
	public boolean addEdge(String edgeName) {
		boolean result = false;
		int n = 0, k = 2;
		try {
			for (int i = 0; n < edgeName.length(); i++) {
				edgeList.add(edgeName.substring(n, k));
				n += 3;
				k += 3;
			}
			result = true;
		} catch (Exception e) {
			System.out.println("addEdge error:" + e.toString());
		}
		return result;
	}

	/*--PHUONG THUC TAO RA MA TRAN KE------------------------------------------------------------------------*/
	public static String[][] createJacentMatrix(String[] verticeList,
			ArrayList<String> edgeList) {
		int size = (verticeList.length + 1);
		String[][] result = new String[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 0 && j == 0)
					result[i][j] = "#";
				else if (i == 0 && j != 0)
					result[i][j] = verticeList[j - 1];
				else if (i != 0 && j == 0)
					result[i][j] = verticeList[i - 1];
				else {
					for (int k = 0; k < edgeList.size(); k++) {
						if ((result[0][j] + result[i][0]).equals(edgeList
								.get(k))
								|| (result[i][0] + result[0][j])
										.equals(edgeList.get(k))) {
							result[i][j] = "1";
							break;
						}
						result[i][j] = "0";
					}
				}
			}
		}
		return result;
	}

	/*--PHUONG THUC TAO RA DANH SACH KE------------------------------------------------------------------------*/
	public String[][] createJacentList(String[] verticeList,
			ArrayList<String> edgeList) {
		String[][] result = new String[verticeList.length][verticeList.length];
		int k, n = 0;
		for (int i = 0; i < result.length; i++) {
			n = 0;
			for (int j = 0; j < result.length; j++) {
				if (j == 0) {
					result[i][j] = verticeList[i];
				} else {
					boolean checkNull = true;
					for (k = n; k < edgeList.size(); k++) {
						checkNull = true;
						if (result[i][0]
								.equals(edgeList.get(k).substring(0, 1))) {
							result[i][j] = edgeList.get(k).substring(1, 2);
							n = k + 1;
							checkNull = false;
							break;
						}
						if (result[i][0]
								.equals(edgeList.get(k).substring(1, 2))) {
							result[i][j] = edgeList.get(k).substring(0, 1);
							n = k + 1;
							checkNull = false;
							break;
						}
					}
					if (checkNull == true) {
						result[i][j] = "";
					}
				}
			}
		}
		return result;
	}

	/*--PHUONG THUC IN RA 1 MA TRAN------------------------------------------------------------------------*/
	public void toString(String[][] jacentMatrix) {
		for (int i = 0; i < jacentMatrix.length; i++) {
			for (int j = 0; j < jacentMatrix.length; j++) {
				String ad = jacentMatrix[i][j];
				System.out.print(jacentMatrix[i][j] + "  ");
			}
			System.out.println("");
		}

	}

	/*--PHUONG THUC LAY RA DANH SACH CAC DINH---------------------------------------------------------------------*/
	public static String[] getVerticeList() {
		String[] result = new String[numVertice];
		for (int i = 0; i < arrayListPoint.size(); i++) {
			result[i] = arrayListPoint.get(i).getVerticeName();
		}
		return result;
	}

	public static ArrayList<Point> getArrayListPoint() {
		return arrayListPoint;
	}

	public static ArrayList<String> getEdgeList() {
		return edgeList;
	}

	public static void setNumVertice(int numVertice) {
		DoThiVoHuong.numVertice = numVertice;
	}
}
