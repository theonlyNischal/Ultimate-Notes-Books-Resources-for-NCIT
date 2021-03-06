;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    number db 09h
    result dw ?

.code
    main proc
        .startup
        xor bx,bx
        xor ax,ax
        mov bl,number
        mov al,bl
        mul bl
        mov result,ax    ;first store to 'result'
        
        aam
        add ax,3030h
        mov dl,ah
        mov dh,al
        mov ah,02h
        int 21h
        mov dl,dh       ; and then display to screen
        int 21h

        .exit
        main endp
    end main
    