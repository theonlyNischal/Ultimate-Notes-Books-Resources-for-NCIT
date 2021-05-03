;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    enter1 db 'Enter num1: ','$'
    enter2 db 10,13,'Enter num2: ','$'
    sumis db 10,13,'The sum is: ','$'

.code
    display proc   ;displays the character in dl register
        push ax
        mov ah,02h
        int 21h
        pop ax
        ret
        display endp
    
    main proc
         .startup
         
         lea dx,enter1 ;display the first message
         mov ah,09h
         int 21h
         
         mov ah,01h  ;take first number input
         int 21h
         
         sub al,30h
         mov bl,al
         
         lea dx,enter2  ;display second message
         mov ah,09h
         int 21h
         
         mov ah,01h      ;take second input
         int 21h
         
         sub al,30h
         add al,bl
         
         aam        ;convert the result into bcd format (Example: if result is 0C, it will get converted to 12)
         add ax,3030h
         
         push ax
         lea dx, sumis ;print 'the sum is ' message
         mov ah,09h
         int 21h
         pop ax
         
         mov dl,ah
         call display      ;print the two digits of result
         mov dl,al
         call display
         
         main endp
    end main
         
         
