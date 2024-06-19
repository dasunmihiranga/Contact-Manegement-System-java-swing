import java.time.LocalDate;
class ContactList {
    private static Node start;

	// Number validation
	public static boolean numberCheck(String pn) {
		char ch = pn.charAt(0);
		if (ch != '0' || (pn.length() != 10)) {
			return true;

		}
		return false;
	}
	public boolean isEmpty(){
		return start==null;
	}
	public static int size(){
		int count=0;
		Node temp=start;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}
	public  void add(Contact contact) {
		Node n1=new Node(contact);
		if(start==null){
			start=n1;
		}else{
			Node lastNode=start;
			while(lastNode.next!=null){
				lastNode=lastNode.next;

			}
			lastNode.next=n1;

		}
	}
	public void remove(int index) {
		if(index>=0 && index<size()){
			if(index==0){
				start=start.next;

			}else{
				int count=0;
				Node temp=start;
				while (count<index-1) {
					count++;
                    temp=temp.next;
					
				}
				temp.next=temp.next.next;
			}  
		}
        	
    }
	public static Contact get(int index){
		if(index>=0 && index<size()){
            int count=0;
            Node temp=start;
            while(count<index){
                count++;
                temp=temp.next;
            }
            return temp.contact;
        }
        return null;

	}

	// Search
	public static int search(String namepn) {
		for (int i = 0; i < size(); i++) {
			Contact tempContact = get(i);
			if ((tempContact.getName()).equals(namepn) || tempContact.getPn().equals(namepn)) {
				return i;
			}

		}
		return -1;
	}

	// Swap and sort in assending order
	public static void swapSort(int j) {
        ContactList contactList = DBConnection.getInstance().getContactList();
		Contact tempContact1 = contactList.get(j);
		Contact tempContact2 = contactList.get(j + 1);

		String name = tempContact1.getName();
		tempContact1.setName(tempContact2.getName());
		tempContact2.setName(name);

		String cid = tempContact1.getCid();
		tempContact1.setCid(tempContact2.getCid());
		tempContact2.setCid(cid);

		String pn = tempContact1.getPn();
		tempContact1.setPn(tempContact2.getPn());
		tempContact2.setPn(pn);

		String cn = tempContact1.getComName();
		tempContact1.setComName(tempContact2.getComName());
		tempContact2.setComName(cn);

		double sal = tempContact1.getSalary();
		tempContact1.setSalary(tempContact2.getSalary());
		tempContact2.setSalary(sal);

		String bd = tempContact1.getBday();
		tempContact1.setBday(tempContact2.getBday());
		tempContact2.setBday(bd);

	}
    public static void sortName() {
        for (int i = 0; i < ContactList.size() - 1; i++) {
			for (int j = 0; j < ContactList.size() - i - 1; j++) {
				Contact tempContact1= ContactList.get(j);
				Contact tempContact2= ContactList.get(j + 1);
				int len1 = tempContact1.getName().length();
				int len2 = tempContact2.getName().length();
				int min = len1;

				if (len1 > len2) {
					min = len2;
				}

				// int min = Math.min(Name[j].length(), Name[j + 1].length());

				for (int k = 0; k < min; k++) {
					char ch1 = tempContact1.getName().charAt(k);
					char ch2 = tempContact2.getName().charAt(k);
					if (ch1 > ch2) {
						swapSort(j);

						break;

					} else if (ch1 < ch2) {
						break;
					}

				}
			}
		}
    }
    public static void SortSalary() {
		for (int i = 0; i < ContactList.size() - 1; i++) {
			for (int j = 0; j < ContactList.size() - i - 1; j++) {
				Contact temContact1=ContactList.get(j);
				Contact temContact2=ContactList.get(j + 1);
				if (temContact1.getSalary() > temContact2.getSalary()) {
					ContactList.swapSort(j);

				}
			}

		}
		

	}
    public static void SortBirthday() {
		int temp[] = new int[ContactList.size()];
		for (int i = 0; i < ContactList.size(); i++) {
			Contact tempContact =ContactList.get(i);
			String y = tempContact.getBday().substring(0, 4);
			String m = tempContact.getBday().substring(5, 6);
			String d = tempContact.getBday().substring(8, 9);

			String bd = y + m + d;
			temp[i] = Integer.parseInt(bd);
		}

		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = 0; j < temp.length - i - 1; j++) {
				if (temp[j] > temp[j + 1]) {
					swapSort(j);
					int x = temp[j];
					temp[j] = temp[j + 1];
					temp[j + 1] = x;

				}

			}

		}

	}
	// Salary validation

	public static boolean checkSalary(double salary) {
		if (salary < 0) {
			return true;
		}
		return false;
	}

	// Substring
	public static int subString(String bday, int a, int b) {
		int z = 0;
		int x = 0;
		for (int i = a; i <= b; i++) {
			char ch = bday.charAt(i);
			switch (ch) {
				case '0':
					x = 0;
					break;
				case '1':
					x = 1;
					break;
				case '2':
					x = 2;
					break;
				case '3':
					x = 3;
					break;
				case '4':
					x = 4;
					break;
				case '5':
					x = 5;
					break;
				case '6':
					x = 6;
					break;
				case '7':
					x = 7;
					break;
				case '8':
					x = 8;
					break;
				case '9':
					x = 9;
					break;
			}
			z = z * 10 + x;

		}
		return z;

	}

	// Birthday validate
	public static boolean checkBirthday(String bday) {
		int y = subString(bday, 0, 3);
		int m = subString(bday, 5, 6);
		int d = subString(bday, 8, 9);

		if (localTime(y, m, d)) {
			return false;
		}

		return true;

	}

	// genreate contact id
	public static int highestContactNumber = 0;

	public static String generateContactId() {

		String cid;
		do {
			highestContactNumber++;
			cid = "C" + String.format("%03d", highestContactNumber);
		} while (isContactIdUsed(cid));
		return cid;
	}

	// Check if Contact ID is used
	public static  boolean isContactIdUsed(String cid) {
		for (int i = 0; i < size(); i++) {
			Contact tempContact=get(i);
			if (cid.equals(tempContact.getCid())) {
				return true;
			}
		}
		return false;
	}
	// Time
	public static boolean localTime(int y, int m, int d) {
		LocalDate localD = LocalDate.now();
		String ld = localD.toString();
		int yld = subString(ld, 0, 3);
		int mld = subString(ld, 5, 6);
		int dld = subString(ld, 8, 9);
		if (yld > y) {
			return true;
		} else if (yld == y) {
			if (mld > m) {
				return true;
			} else if (mld == m) {
				if (dld > d) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	class Node{
		private Contact contact;
		private Node next;
		Node(Contact contact){
            this.contact = contact;
        }
		
	}
}