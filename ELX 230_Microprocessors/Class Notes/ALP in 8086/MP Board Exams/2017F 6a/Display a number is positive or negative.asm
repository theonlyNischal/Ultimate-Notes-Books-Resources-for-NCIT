;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    number db 079h
    positive db 'number is positive','$'
    negative db 'number is negative','$'

.code
    main proc
        .startup
        
        mov al,number
        test al,10000000b
        jnz neg
            lea dx,positive
            mov ah,09h
            int 21h
            jmp last
        
        neg:
        lea dx,negative
        mov ah,09h
        int 21h
        
        last:
        main endp
    end main
        
        