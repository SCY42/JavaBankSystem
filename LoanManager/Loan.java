package LoanManager;

import java.util.Scanner;

public class Loan {
	public boolean isloan;
	public int amount;
	public int balance; // 에러 방지를 위한 임시 변수
	Scanner sc = new Scanner(System.in);
	
	public Loan()
    {
		this.isloan = false;
		this.amount = 0;
		
    }
	public void loanMenu()
    {
        System.out.println("1 - 대출");
        System.out.println("2 - 대출 가능 금액 조회	");
        System.out.println("3 - 대출 상환");
        String selection = this.sc.nextLine();

        switch (selection) {
            case "1":
                this.getloan();
                break;
            case "2":
                this.howmuch();
                break;
            case "3":
            	this.repay();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }
	
	public void getloan()
	{
		System.out.println("대출 서비스입니다.");
		System.out.println("대출 금액을 입력하세요. : ");
		try {
        int amount = Integer.parseInt(this.sc.nextLine());
        if(amount>100) {
        	System.out.println("최대 1000만원까지 가능합니다.");
        	this.getloan();
        }
        //사용자 후 수정 
	if(amount>0)
	{
        System.out.println(amount+"만원 대출 완료했습니다.");
        //System.out.println("현재 잔액 : "+this.balance);
	}
        }catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            this.getloan();
        }
	}
	
	public void howmuch()
	{
		if(this.isloan==true) {
			System.out.println("대출중입니다.");
			System.out.println(100-amount+"만원 추가 대출 가능합니다.");
			
			
		}
		else {
			System.out.println("신규 대출입니다.");
			System.out.println("1000만원 추가 대출 가능합니다.");
		}
	}
	
	public void repay()
	{
		if(isloan==false) {
			System.out.println("대출 중이 아닙니다.");
			this.loanMenu();
		}
		else {
			System.out.println("상환 금액을 입력하세요. :");
			try {
	            int amount = Integer.parseInt(this.sc.nextLine());
	            //사용자 후 수정 
	            System.out.println(String.format("성공적으로 %d원이 상환되었습니다!",amount));
	            System.out.println(String.format("현재 잔액: %d", this.balance));
	        }
	        catch (NumberFormatException e) {
	            System.out.println("잘못된 입력입니다.");
	            this.repay();
	        }
		}
	}

}
