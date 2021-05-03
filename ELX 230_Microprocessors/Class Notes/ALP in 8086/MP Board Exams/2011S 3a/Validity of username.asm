;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    enter db 'Enter Username: ','$'
    user db 'Pokhara University',13
    ulength db 19
    input db 25 dup(?)
    valid db 10,13,'valid user','$'
    error db 10,13,'invalid user','$'

.code
    display proc   ;display whatever string dx is pointing to
        push ax
        mov ah,09h
        int 21h
        pop ax
        ret
        display endp
    
    main proc
        mov ax,@data
        mov ds,ax      ;load both data and extra segment
        mov es,ax      ;extra segment is necessary for compsb instruction
        
        lea dx,enter
        call display  ;display 'enter reg no. ' message
        
        lea di,input  ;we need to put the input from keyboard in 'input' variable
        inputagain:
             mov ah,01h
             int 21h
             mov [di],al
             cmp al,13
             je inputfinished   ;input characters from keyboard till enter key is pressed
             inc di
             jmp inputagain
        inputfinished:
        lea si,user
        lea di,input
        xor cx,cx
        mov cl,ulength   ;the length of registration number. we have to compare each character only 'cx' times
        
        repe cmpsb       ;repeatedly compare [si] and [di] till mismatch occur or cx reaches zero. meanwhile, in every comparision, increase si, di and decrease cx
        jz success       ;if zero flag is still set after comparision, this means two strings were equal
            lea dx,error
            call display
            jmp last
        success:
        lea dx,valid
        call display
        last:
        
        main endp
    end main
            
        