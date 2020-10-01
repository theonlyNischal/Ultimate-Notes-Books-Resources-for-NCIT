%{
  Title: Root using Bisection Method
  Author: Nischal Lal Shrestha
  Date: 20 June, 2018


%}


% Define Function
f = input('Enter the function: ', 's');
f = inline(f);

%{
  You can also add your own custom function directly,
  like f = sin(x) - 4*cos(x);
%}

% Define Error
E = 0.00005;

% Root interval [a,b]

a = input('Enter the start root interval: ');
b = input('Enter the end root interval: ');

% Functional Value of root interval
fa = f(a);
fb = f(b);

% Select those root interval who have difference in sign.
while(fa*fb > 0)
  % This loop run until a difference in sign is encountered,
  % This makes sure that at least one root is bracketed.
  a = input('Enter the start root interval: ');
  b = input('Enter the end root interval: ');

  % Functional Value of root interval
  fa = f(a);
  fb = f(b);
end
step = 0;
  disp('Step a         f(a)         b           f(b)        x        f(x)');

while(abs(b-a)>E)

  x = (a+b)/2;
  fx=f(x);
  step =step + 1;
  result = [step,a,f(a),b,f(b),x,f(x)];
  disp(result);
  
  if(f(x)==0)
  result = strcat('The root lies at x = ',num2str(x));
  disp(result); 
  end
 
 if(f(a)*f(x)<0)
  b=x;
 else
  a=x;
 end
 
%  result = [a,fa,b,fb,x,fx];
%  disp(result);
end


if (f(x) ~= 0)
  disp('-----------------------------');

  result = strcat('The root lies at x = ', num2str(x));
  disp(result);
end


  
