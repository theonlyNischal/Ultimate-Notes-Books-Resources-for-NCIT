%{
  Title: Root using Bisection Method
  Author: Nischal Lal Shrestha
  Date: 20 June, 2018


%}


% Define Function
f = input('Enter the function: ', 's');
f = inline(f);

% Define Error
E = 0.00005;

% Root interval [a,b]

a = input('Enter the start root interval: ');
b = input('Enter the end root interval: ');

% Functional Value of root interval
fa = f(a);
fb = f(b);

% Select those root interval who have difference in sign
while(fa*fb > 0)
  % This loop run until a difference in sign is encountered
  a = input('Enter the start root interval: ');
  b = input('Enter the end root interval: ');

  % Functional Value of root interval
  fa = f(a);
  fb = f(b);
end

n = ceil((log(abs(b-a)) - log10(E)/ log10(2)));
result = [a,fa,b,fb];
disp(result);
  disp('    a       f(a)       b         f(b)     x     f(x)');
while((abs(b-a)>E) || n > 0)
  disp(n);
  n = n-1;
  x = (a+b)/2;
  fx=f(x);

  result = [a,fa,b,fb,x,fx];
  disp(result);
  
  if(fx==0)
  result = strcat('The root lies at x = ',num2str(x));
  disp(result); 
  end
 
 if(fa*fx<0)
  b=x;
 else
  a=x;
 end
 
 result = [a,fa,b,fb,x,fx];
 disp(result);
end

disp('-----------------------------');

result = strcat('The root lies at x = ', num2str(x));
disp(result);


  
