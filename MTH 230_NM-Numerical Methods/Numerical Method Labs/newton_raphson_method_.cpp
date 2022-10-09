#include<stdio.h>
#include<math.h>
#define e 0.000001
//#define f(x) pow(x,4)-x-10
//#define df(x) 4*x*x*x-1
//#define f(x) pow(x,3)-3*x+1
//#define df(x) 3*x*x-3
#define f(x) 3*x - cos(x) -1
#define df(x) 3 +sin(x)

int main()
{
	float x0 , x1 , f0 , f1 , df0;
	int i = 0;
	printf("Enter the value of x0 \n");
	scanf("%f" , &x0);
	do
	{
		f0 = f(x0);
		df0 = df(x0);
		x1 = x0 - (f0 / df0); //general formula of newton raphson method
		f1 = f(x1);
		x0 = x1;
		i++;
		printf("No of iterations = %d\t", i);
		printf("root = %f \t", x1);
		printf("Value of funtion = %f \n",f1);
	} while(fabs(f1)>e);
	return 0;
}


